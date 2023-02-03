import { Component } from '@angular/core';
import { Boots } from '../interfaces/boots';
import { Task1Service } from '../services/task1.service';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.scss', '../app.component.scss']
})
export class ButtonComponent {
  title = 'lab1fr';
  itemsList:Boots[]=[];
  
  constructor(private service:Task1Service){}

  getItems():void{
    this.service.getItems().subscribe(
      (items)=>{
        this.itemsList=items;
      }
    )
  }

}
