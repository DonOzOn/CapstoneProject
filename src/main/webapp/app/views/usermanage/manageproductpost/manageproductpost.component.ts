import { Component, OnInit } from '@angular/core';
import { SelectItem } from 'primeng/api';
import { CarService } from 'app/core/service/car.service';

export interface Car {
  vin: any;
  year: any;
  brand: any;
  color: any;
}
@Component({
  selector: 'app-manageproductpost',
  templateUrl: './manageproductpost.component.html',
  styleUrls: ['./manageproductpost.component.scss']
})
export class ManageproductpostComponent implements OnInit {
  cars: Car[];

  selectedCar: Car;

  displayDialog: boolean;

  sortOptions: SelectItem[];

  sortKey: string;

  sortField: string;

  sortOrder: number;
  constructor(private carService: CarService) { }

  ngOnInit() {
    this.getlistCar();
    this.sortOptions = [
      { label: 'Newest First', value: '!year' },
      { label: 'Oldest First', value: 'year' },
      { label: 'Brand', value: 'brand' }
    ];
  }
  getlistCar() {
    this.carService.getListCar().subscribe(res => {
      this.cars = res.data.rows;
    });
  }
  selectCar(event: Event, car: Car) {
    this.selectedCar = car;
    this.displayDialog = true;
    event.preventDefault();
  }

  onSortChange(event: { value: any; }) {
    const value = event.value;

    if (value.indexOf('!') === 0) {
      this.sortOrder = -1;
      this.sortField = value.substring(1, value.length);
    } else {
      this.sortOrder = 1;
      this.sortField = value;
    }
  }

  onDialogHide() {
    this.selectedCar = null;
  }
}
