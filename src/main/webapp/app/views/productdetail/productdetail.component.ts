import { Component, OnInit } from '@angular/core';
import { PostService } from 'app/core/post/post.service';
import { PostRespone } from 'app/core/post/model/postRespone.model';
import { NewsService } from 'app/core/service/news.service';
import { ActivatedRoute } from '@angular/router';
import { SERVER_API_URL } from 'app/app.constants';

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
  listNews: any[];
  productdetal: PostRespone;
  constructor(private postService: PostService, private newService: NewsService, private activatedRoute: ActivatedRoute) {}
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
    this.getlistNews();
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
}
