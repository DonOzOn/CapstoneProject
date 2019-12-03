import { Component, OnInit } from '@angular/core';
import { PostService } from 'app/core/post/post.service';
import { PostRespone } from 'app/core/post/model/postRespone.model';
import { ActivatedRoute, Router } from '@angular/router';
import { SERVER_API_URL } from 'app/app.constants';
import { NewsService } from 'app/core/news/news.service';

@Component({
  selector: 'app-productdetail',
  templateUrl: './productdetail.component.html',
  styleUrls: ['./productdetail.component.scss']
})
export class ProductdetailComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  images: any[];
  listImage: any = [];
  productdetail: any;
  list4News: any[];
  productdetal: PostRespone;
  constructor(
    private postService: PostService,
    private newService: NewsService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}
  ngOnInit() {
    this.activatedRoute.data.subscribe(res => {
      this.productdetail = res.detailProduct;
      // eslint-disable-next-line
      console.log(' post : ', this.productdetail.imageDTO);
      this.listImage.push(this.productdetail.imageDTO.img1);
      this.listImage.push(this.productdetail.imageDTO.img2);
      this.listImage.push(this.productdetail.imageDTO.img3);
      this.listImage.push(this.productdetail.imageDTO.img4);
      this.listImage.push(this.productdetail.imageDTO.img5);
      this.listImage.push(this.productdetail.imageDTO.img6);
      this.listImage.push(this.productdetail.imageDTO.img7);
      this.listImage.push(this.productdetail.imageDTO.img8);
      this.listImage.push(this.productdetail.imageDTO.img9);
      this.listImage.push(this.productdetail.imageDTO.img10);
    });
    // eslint-disable-next-line
    console.log(' post : ', this.listImage);
    this.getlist4News();
  }

  /*  get  list 4 new*/
  getlist4News() {
    this.newService.getListNews().subscribe(res => {
      this.list4News = res.body;
      // eslint-disable-next-line
      console.log('Listnew  : ', this.list4News);
      this.list4News.sort(function(obj1, obj2) {
        return new Date(obj2.createdDate).valueOf() - new Date(obj1.createdDate).valueOf();
      });
      this.list4News = res.body.slice(0, 4);
    });
  }

  goToNews(id: any) {
    // tslint:disable-next-line: no-unused-expression
    this.router.navigate(['/news', id, 'detail']);
  }
}
