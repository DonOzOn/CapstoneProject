import { Component, OnInit, HostListener } from '@angular/core';

@Component({
  selector: 'app-go-to-top',
  templateUrl: './gotoTop.component.html',
  styleUrls: ['./gotoTop.component.scss']
})
export class GotoTopComponent implements OnInit {
  isShow: boolean;
  topPosToStartShowing = 100;
  constructor() { }

  ngOnInit() {
  }
  @HostListener('window:scroll')
  checkScroll() {
    // window의 scroll top
    // Both window.pageYOffset and document.documentElement.scrollTop returns the same result in all the cases. window.pageYOffset is not supported below IE 9.

    const scrollPosition = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;

    if (scrollPosition >= this.topPosToStartShowing) {
      this.isShow = true;
    } else {
      this.isShow = false;
    }
  }

  // TODO: Cross browsing
  gotoTop() {
    window.scroll({
      top: 0,
      left: 0,
      behavior: 'smooth'
    });
  }

}
