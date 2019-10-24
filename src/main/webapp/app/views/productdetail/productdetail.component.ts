import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-productdetail',
  templateUrl: './productdetail.component.html',
  styleUrls: ['./productdetail.component.scss']
})
export class ProductdetailComponent implements OnInit {
  images: any[];
  constructor() {}

  ngOnInit() {
    this.images = [];
    this.images.push({ source: '/content/img/cropped-welcome-to-danang.jpg', alt: 'Description for Image 1', title: 'Title 1' });
    this.images.push({ source: '/content/img/cropped-welcome-to-danang.jpg', alt: 'Description for Image 2', title: 'Title 2' });
    this.images.push({ source: '/content/img/cropped-welcome-to-danang.jpg', alt: 'Description for Image 3', title: 'Title 3' });
    this.images.push({ source: '/content/img/cropped-welcome-to-danang.jpg', alt: 'Description for Image 4', title: 'Title 4' });
    this.images.push({ source: '/content/img/cropped-welcome-to-danang.jpg', alt: 'Description for Image 5', title: 'Title 5' });
    this.images.push({ source: '/content/img/cropped-welcome-to-danang.jpg', alt: 'Description for Image 6', title: 'Title 6' });
    this.images.push({ source: '/content/img/cropped-welcome-to-danang.jpg', alt: 'Description for Image 7', title: 'Title 7' });
    this.images.push({ source: '/content/img/cropped-welcome-to-danang.jpg', alt: 'Description for Image 8', title: 'Title 8' });
    this.images.push({ source: '/content/img/cropped-welcome-to-danang.jpg', alt: 'Description for Image 9', title: 'Title 9' });
    this.images.push({ source: '/content/img/cropped-welcome-to-danang.jpg', alt: 'Description for Image 10', title: 'Title 10' });
    this.images.push({ source: '/content/img/cropped-welcome-to-danang.jpg', alt: 'Description for Image 11', title: 'Title 11' });
    this.images.push({ source: '/content/img/cropped-welcome-to-danang.jpg', alt: 'Description for Image 12', title: 'Title 12' });
  }

  onDialogClick(event: UIEvent) {
    // Capture click on dialog and prevent it from bubbling to the modal background.
    event.stopPropagation();
    event.cancelBubble = true;
  }
}
