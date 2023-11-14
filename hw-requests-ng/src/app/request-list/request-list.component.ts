import { RequestService } from './../service/request.service';
import { Request } from './../model/request';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-request-list',
  templateUrl: './request-list.component.html',
  styleUrls: ['./request-list.component.css']
})
export class RequestListComponent implements OnInit {

  requests: Request[];

  constructor(private requestService: RequestService) { }

  ngOnInit() {
    this.requestService.findAll().subscribe((data: any) => {
      this.requests = data;
    })
  }
}
