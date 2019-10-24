import { OnInit, Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { SelectItem } from 'primeng/components/common/selectitem';

interface City {
  name: string;
  code: string;
}
@Component({
  selector: 'app-postproduct',
  templateUrl: './postproduct.component.html',
  styleUrls: ['./postproduct.component.scss']
})
export class PostproductComponent implements OnInit {
  profileForm = new FormGroup({
    projectname: new FormControl(),
    type: new FormControl(),
    typeBDS: new FormControl(),
    title: new FormControl(),
    one: new FormControl(),
    two: new FormControl(),
    three: new FormControl(),
    four: new FormControl()
  });
  types: SelectItem[];
  selectedType: string;
  typeBDS: City[];
  selectedBDS: City;
  text1 = '<div>Hello World!</div><div>PrimeNG <b>Editor</b> Rocks</div><div><br></div>';
  uploadedFiles: any[] = [];
  selectedCategories: string[] = [];
  checked = false;
  constructor() {
    this.types = [{ label: 'Mua bán', value: 'PayPal' }, { label: 'Cho thuê', value: 'Visa' }];
    this.typeBDS = [
      { name: 'New York', code: 'NY' },
      { name: 'Rome', code: 'RM' },
      { name: 'London', code: 'LDN' },
      { name: 'Istanbul', code: 'IST' },
      { name: 'Paris', code: 'PRS' }
    ];
  }

  ngOnInit() {}
  onUpload(event) {
    for (const file of event.files) {
      this.uploadedFiles.push(file);
    }
  }
}
