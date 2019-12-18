import { Component, OnInit } from '@angular/core';
import { PostService } from 'app/core/post/post.service';
import { PostRespone } from 'app/core/post/model/postRespone.model';
import { SERVER_API_URL } from 'app/app.constants';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.scss']
})
export class GalleryComponent implements OnInit {
  listProduct: PostRespone[];
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  listImage: string[] = [];
  constructor(private postService: PostService) {}

  ngOnInit() {
    // eslint-disable-next-line
    console.log('List product: ');
    this.postService.query().subscribe(res => {
      this.listProduct = res.body;
      // eslint-disable-next-line
      for (let i = 0; i < this.listProduct.length; i++) {
        if (this.listProduct[i].imageDTO.img1 != null) {
          this.listImage.push(this.listProduct[i].imageDTO.img1);
        }
        if (this.listProduct[i].imageDTO.img2 != null) {
          this.listImage.push(this.listProduct[i].imageDTO.img2);
        }
        if (this.listProduct[i].imageDTO.img3 != null) {
          this.listImage.push(this.listProduct[i].imageDTO.img3);
        }
        if (this.listProduct[i].imageDTO.img4 != null) {
          this.listImage.push(this.listProduct[i].imageDTO.img4);
        }
        if (this.listProduct[i].imageDTO.img5 != null) {
          this.listImage.push(this.listProduct[i].imageDTO.img5);
        }
        if (this.listProduct[i].imageDTO.img6 != null) {
          this.listImage.push(this.listProduct[i].imageDTO.img6);
        }
        if (this.listProduct[i].imageDTO.img7 != null) {
          this.listImage.push(this.listProduct[i].imageDTO.img7);
        }
        if (this.listProduct[i].imageDTO.img8 != null) {
          this.listImage.push(this.listProduct[i].imageDTO.img8);
        }
        if (this.listProduct[i].imageDTO.img9 != null) {
          this.listImage.push(this.listProduct[i].imageDTO.img9);
        }
        if (this.listProduct[i].imageDTO.img10 != null) {
          this.listImage.push(this.listProduct[i].imageDTO.img10);
        }
      }
      // eslint-disable-next-line
      console.log('List image: ', this.listImage);
    });
  }
}
