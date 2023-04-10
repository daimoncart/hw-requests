import { RequestService } from './../service/request.service';
import { Component, OnInit } from '@angular/core';
import { Request } from '../model/request';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-request-view',
  templateUrl: './request-view.component.html',
  styleUrls: ['./request-view.component.css']
})
export class RequestViewComponent implements OnInit {
  request: Request;
  constructor (
    private requestService: RequestService,
    private route: ActivatedRoute, 
    private router: Router 
  ){}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id')!!;
    this.requestService.getRequestById(id).subscribe(data => {
      console.log(data);
      this.request = data;
      console.log(this.request);
  });
  }

  approveRequest(): void {
    this.request.status = 'Approved';    
    this.requestService.save(this.request).subscribe(result => this.gotoRequestList());
  }

  rejectRequest(): void {
    this.request.status = 'Rejected';
    this.requestService.save(this.request).subscribe(result => this.gotoRequestList());
  }

  
  gotoRequestList() {
    this.router.navigate(['/requests']);
  }
}
