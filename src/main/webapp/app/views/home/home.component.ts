import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl } from '@angular/forms';
import { AddressService } from 'app/core/address/address.service';
import { PostService } from 'app/core/post/post.service';
import { PostRespone } from 'app/core/post/model/postRespone.model';
import { SERVER_API_URL } from 'app/app.constants';
import { NewsService } from 'app/core/news/news.service';
import { Router } from '@angular/router';
import { AccountService } from 'app/core/auth/account.service';
import { UserService } from 'app/core/user/user.service';
import { IUser } from 'app/core/user/user.model';
import { Account } from 'app/core/user/account.model';
let self: any;
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  count: any;
  currentAccount: Account;
  currentUser: IUser;
  searchText = new FormControl('');
  choose = [{ value: '', name: 'Toàn bộ' }, { value: 1, name: 'Mua bán' }, { value: 2, name: 'Cho thuê' }];
  chooseForm = this.fb.group({
    choose: ['']
  });

  carouselOptions = {
    dots: false,
    navigation: false,
    autoplay: true,
    loop: true,
    responsiveClass: true,
    responsive: {
      0: {
        items: 1,
        autoplayTimeout: 1500,
        autoplayHoverPause: true
      },
      520: {
        items: 2,
        autoplayTimeout: 2500,
        autoplayHoverPause: true
      },
      768: {
        items: 3,
        autoplayTimeout: 3500,
        autoplayHoverPause: true
      },
      1024: {
        items: 4,
        autoplayTimeout: 4500,
        autoplayHoverPause: false
      },
      1600: {
        items: 5,
        autoplayTimeout: 5500,
        autoplayHoverPause: false
      },
      1920: {
        items: 6,
        autoplayTimeout: 6500,
        autoplayHoverPause: false
      }
    }
  };

  listProvinces = [];
  listNumPost = [];
  listUsers: IUser[] = [];
  listUserTop = [];
  post: PostRespone[] = [];
  listHotPost = [];
  list15HotPostProduct = [];
  listNewPost = [];
  list15NewPostProduct = [];
  /* pagination */
  public directionLinks = true;
  public autoHide = false;
  public responsive = true;
  public maxSize = 5;
  listPagination: any[] = [];
  config: any;
  public labels: any = {
    previousLabel: 'Trước',
    nextLabel: 'Sau'
  };
  responsiveOptions;
  window: any;

  constructor(
    private addressService: AddressService,
    private fb: FormBuilder,
    private postService: PostService,
    private newService: NewsService,
    private userService: UserService,
    private router: Router,
    private accountService: AccountService
  ) {
    for (let i = 0; i < this.count; i++) {
      this.listPagination.push({
        id: i + 1,
        value: 'items number' + (i + 1)
      });
    }
    this.config = {
      itemsPerPage: 5,
      currentPage: 1,
      totalItems: this.count
    };
    this.responsiveOptions = [
      {
        breakpoint: '1920px',
        numVisible: 5,
        numScroll: 5
      },
      {
        breakpoint: '1600px',
        numVisible: 4,
        numScroll: 4
      },
      {
        breakpoint: '1024px',
        numVisible: 3,
        numScroll: 3
      },
      {
        breakpoint: '768px',
        numVisible: 2,
        numScroll: 2
      },
      {
        breakpoint: '560px',
        numVisible: 1,
        numScroll: 1
      }
    ];
  }

  /*  get total page in pagination*/
  getTotalPage() {
    this.postService.getAllWithNoPaging().subscribe(res => {
      this.count = res.body.length;
      return this.count;
    });
  }
  pageChanged(event) {
    this.config.currentPage = event;
  }

  ngOnInit() {
    this.getList15HotPostProduct();
    this.getList15NewPostProduct();
    this.getProvince();
    this.getListPostProduct();
    this.accountService.identity().subscribe((account: Account) => {
      this.currentAccount = account;
    });
    self = this;
    this.window = window;
    this.window.addEventListener('saveToken', this.saveUserToken);
    this.window.addEventListener('messageRecieve', this.messageRecieved);

    if (this.accountService.isAuthenticated() === true) {
      this.window.window.requestPermission();
    }

    // this.window.addEventListener('subcribeTopicScript', this.test);
  }

  redirectTo(uri: string) {
    this.router.navigateByUrl('/usermanage', { skipLocationChange: true }).then(() => this.router.navigate([uri]));
  }

  messageRecieved(e) {
    // eslint-disable-next-line
    console.log('get mess: ', e.detail);
  }
  saveUserToken(e) {
    self.userService.find(self.currentAccount.login).subscribe((userAuthen: IUser) => {
      self.currentUser = userAuthen;
      self.currentUser.token = e.detail;
      self.userService.update(self.currentUser).subscribe(res => {});
    });
  }
  /**
   * Gets list post product
   */
  getListPostProduct() {
    this.postService.getAllWithNoPaging().subscribe(res => {
      this.post = res.body;
      // eslint-disable-next-line no-console
      console.log('list post: ', this.post);
      this.listUsers = this.deduplicate(this.post);
      // this.listUserTop = this.listUsers;
      // this.listUserTop.sort(function(obj1, obj2) {
      //   return (
      //     obj2.productPostResponseDTO.totalReport - obj1.productPostResponseDTO.totalReport ||
      //     new Date(obj2.productPostResponseDTO.createdDate).valueOf() - new Date(obj1.productPostResponseDTO.createdDate).valueOf()
      //   );
      // });
      // // eslint-disable-next-line
      // console.log('listUserTop: ', this.listUserTop);
      // this.listUsers = this.listUserTop.slice(0, 10);
      // // eslint-disable-next-line
      // console.log('listUsers: ', this.listUsers);
    });
  }

  /**
   * Gets list 15 new post product
   */
  getList15NewPostProduct() {
    this.postService.getAllWithNoPaging().subscribe(res => {
      this.listNewPost = res.body;
      this.listNewPost.sort(function(obj1, obj2) {
        return new Date(obj2.productResponseDTO.createdDate).valueOf() - new Date(obj1.productResponseDTO.createdDate).valueOf();
      });
      this.list15NewPostProduct = this.listNewPost.slice(0, 15);
    });
  }

  /**
   * Gets list 15 hot post product
   */
  getList15HotPostProduct() {
    this.postService.getAllWithNoPaging().subscribe(res => {
      this.listHotPost = res.body;
      this.listHotPost.sort(function(obj1, obj2) {
        return (
          obj2.productPostResponseDTO.totalLike - obj1.productPostResponseDTO.totalLike ||
          new Date(obj2.productPostResponseDTO.createdDate).valueOf() - new Date(obj1.productPostResponseDTO.createdDate).valueOf()
        );
      });
      this.list15HotPostProduct = this.listHotPost.slice(0, 15);
    });
  }

  deduplicate(arr) {
    // eslint-disable-next-line
    let isExist = (arr, x) => {
      for (let i = 0; i < arr.length; i++) {
        if (arr[i].productPostResponseDTO.user.id === x.productPostResponseDTO.user.id) {
          return true;
        }
      }
      return false;
    };
    // eslint-disable-next-line
    let ans = [];
    arr.forEach(element => {
      if (!isExist(ans, element)) {
        this.postService.listAllByUserID({ id: element.productPostResponseDTO.user.id, page: 0, size: 10, sort: null }).subscribe(res => {
          element.productPostResponseDTO.totalReport = res.body.length;
        });
        ans.push(element);
      }
    });
    // eslint-disable-next-line no-console
    console.log('list User: ', ans);
    return ans;
  }
  /*  get all provinces */
  getProvince() {
    this.addressService.filterProvince().subscribe((res: any) => {
      this.listProvinces = res.body;
    });
  }

  /**
   * Go to news
   * @param id
   */
  goToNews(id: any) {
    // tslint:disable-next-line: no-unused-expression
    this.router.navigate(['/news', id, 'detail']);
  }

  onChange($event) {}

  /**
   * Searchs
   */
  search() {
    this.router.navigate(['/listproduct', 'fullTextSearch', this.searchText.value]);
  }
}
