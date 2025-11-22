import { Component } from '@angular/core';

@Component({
  selector: 'app-avatar',
  templateUrl: './avatar.html',
  styleUrl: './avatar.css',
  standalone: false
})
export class Avatar {

    urlImage : string = `assets/`;
    selectedIndex : number = -1;

    fileName : string[] = [
        'a1.jpg',
        'a2.jpg',
        'a3.jpg',
        'a4.jpg',
        'a5.jpg',
        'a6.png',
    ];

    selectAvatar(index: number) {
        this.selectedIndex = index;
    }


    
}
