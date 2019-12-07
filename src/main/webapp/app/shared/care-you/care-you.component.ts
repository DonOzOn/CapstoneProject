import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-care-you',
  templateUrl: './care-you.component.html',
  styleUrls: ['./care-you.component.scss']
})
export class CareYouComponent implements OnInit {
  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit() {}
}
