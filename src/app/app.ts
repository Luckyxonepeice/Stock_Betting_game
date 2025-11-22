import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserModule } from './component/User/user-module';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrl: './app.css',
  imports: [RouterOutlet, UserModule],
  standalone: true
})
export class App {
  
  constructor() {
    console.log('App component initialized');
  }
}
