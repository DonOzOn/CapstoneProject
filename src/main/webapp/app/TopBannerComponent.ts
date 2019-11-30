import { Component, AfterViewInit } from '@angular/core';

@Component({
  moduleId: module.id,
  selector: 'app-google-adsense',
  template: `
    <div>
      <!-- localhost -->
      <ins
        class="adsbygoogle"
        style="display:block"
        data-ad-client="ca-pub-8504781071264859"
        data-ad-slot="2029121527"
        data-ad-format="auto"
        data-full-width-responsive="true"
      ></ins>
    </div>
    <br />
  `
})
export class TopBannerComponent implements AfterViewInit {
  constructor() {}

  ngAfterViewInit() {
    setTimeout(() => {
      try {
        (window['adsbygoogle'] = window['adsbygoogle'] || []).push({});
      } catch (e) {
        // eslint-disable-next-line
        console.error('error', e);
      }
    }, 2000);
  }
}
