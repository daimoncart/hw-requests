import { RequestFormComponent } from './request-form/request-form.component';
import { RequestListComponent } from './request-list/request-list.component';
import { NgModule } from '@angular/core';
import {Routes, RouterModule } from '@angular/router';
import { RequestViewComponent } from './request-view/request-view.component';

const routes: Routes = [
  { path: 'requests', component: RequestListComponent},
  { path: 'addrequest', component: RequestFormComponent},
  { path: 'requests/:id', component: RequestViewComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
