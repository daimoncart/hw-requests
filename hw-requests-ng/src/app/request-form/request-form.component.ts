import { CATEGORIES } from './../data-lists/component-categories';
import { RequestService } from './../service/request.service';
import { Request } from './../model/request';
import { Component as ComponentDto} from './../model/component';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { FormGroup, FormControl, FormBuilder, Validators, FormArray, PatternValidator } from '@angular/forms';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';

@Component({
  selector: 'app-request-form',
  templateUrl: './request-form.component.html',
  styleUrls: ['./request-form.component.css']
})
export class RequestFormComponent implements OnInit {
  requestForm: FormGroup;
  valueChangedTracked: any;
  request: Request = new Request();
  categories = CATEGORIES;

  isRequestInProgress = false;

  constructor(
    private formBuilder: FormBuilder, 
    private route: ActivatedRoute, 
    private router: Router, 
    private requestService: RequestService
  ) { 
    this.requestForm = formBuilder.group({
      reasoning: ['', [Validators.required, Validators.minLength(14)]],
      componentBlock: this.formBuilder.array([
        this.createComponentBlock()
      ])
    });
  }

  onSubmit(requestForm: FormGroup) {
    if (this.isRequestInProgress) {
      return;
    }

    this.request = this.requestForm.getRawValue();
    this.request.status = 'New';
    console.log(this.request);
    this.requestService.save(this.request).subscribe(result => this.gotoRequestList());
  }

  gotoRequestList() {
    this.router.navigate(['/requests']);
  }

  resetForm() {
    this.requestForm.reset();
    this.items.clear();
    this.addItem();
  }

  ngOnInit(): void {
    this.requestForm.valueChanges.subscribe (data =>
      this.valueChangedTracked = data);
  }

  get items() {
    return this.requestForm.get('componentBlock') as FormArray;
  }

  removeItem(i: number) {
    if (this.items.length === 1) {return;}
    this.items.removeAt(i);
  }

  private createComponentBlock() {
    return this.formBuilder.group({
      category: ['', Validators.required],
      model: ['', Validators.required],
      quantity: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
      price: ['', Validators.required]
      // category: new FormControl(),
      // model: new FormControl(),
      // quantity: new FormControl(),
      // price: new FormControl()
    });
  }

  addItem() {
    this.items.push(this.createComponentBlock());
  }

  componentsearch = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      distinctUntilChanged(),
      map(term => term.length < 1 ? []
        : this.categories.filter(v => v.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 20))
    )

  // get fControls() {
  //   return this.requestForm.controls['componentBlock'] as FormArray;
  // }      

}
