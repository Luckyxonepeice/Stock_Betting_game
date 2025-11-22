import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Avatar } from './avatar/avatar';



@NgModule({
  declarations: [Avatar],
  imports: [
    CommonModule
  ],
  exports: [Avatar]
})
export class UserModule { }
