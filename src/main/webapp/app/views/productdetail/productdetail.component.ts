import { Component, OnInit } from '@angular/core';
import { PostService } from 'app/core/post/post.service';
import { PostRespone } from 'app/core/post/model/postRespone.model';
import { NewsService } from 'app/core/service/news.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-productdetail',
  templateUrl: './productdetail.component.html',
  styleUrls: ['./productdetail.component.scss']
})
export class ProductdetailComponent implements OnInit {
  images: any[];
  productdetail: any;
  listNews: any[] = [];
  productdetal: PostRespone[];
  constructor(private postService: PostService, private newService: NewsService, private activatedRoute: ActivatedRoute) {}
  ngOnInit() {
    this.activatedRoute.data.subscribe(res => {
      this.productdetail = res.detailProduct;
      // eslint-disable-next-line
      console.log(' post : ', this.productdetail);
    });
    this.getlistNews();
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
  /*  get  list 4 new*/
  getlistNews() {
    this.newService.getListNews().subscribe(res => {
      this.listNews = res.data.rows;
      this.listNews.sort(function(obj1, obj2) {
        return obj2.timeCreate - obj1.timeCreate;
      });
      this.listNews = res.data.rows.slice(0, 4);
    });
  }

  onDialogClick(event: UIEvent) {
    // Capture click on dialog and prevent it from bubbling to the modal background.
    event.stopPropagation();
    event.cancelBubble = true;
  }
}
