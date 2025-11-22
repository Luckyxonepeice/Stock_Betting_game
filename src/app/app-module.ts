import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { App } from './app';
import { RouterModule, RouterOutlet } from '@angular/router';
import { routes } from './app.routes';



@NgModule({
  declarations: [App],
  imports: [
    CommonModule,
    RouterOutlet,
    RouterModule.forRoot(routes)
  ]
})
export class AppModule { }
