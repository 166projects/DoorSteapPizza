import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-foodcount',
  templateUrl: './foodcount.component.html',
  styleUrls: ['./foodcount.component.css']
})
export class FoodcountComponent {
  @Input()
  all;
  @Input()
  veg;
  @Input()
  nonveg;
  selectedRadioButtonValue = 'All';
  @Output()
  countRadioButtonSelectionChanged: EventEmitter<string> = new EventEmitter<string>();
  onRadioButtonSelectionChange()
  {
    this.countRadioButtonSelectionChanged.emit(this.selectedRadioButtonValue);
  }
}
