import { Component } from '@angular/core';
import { Boots } from '../interfaces/boots';
import { Task1Service } from '../services/task1.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.scss', '../app.component.scss']
})
export class ButtonComponent {
  title = 'Lab6FrontEnd';
  itemsList:Boots[]=[];
  
  constructor(private service:Task1Service){}

  getItems():void{
    this.service.getItems().subscribe(
      (items)=>{
        this.itemsList=items;
      }
    )
  }
  
  name:string = "";
  size:number = 0;
  price:number = 0;
  image: string = "";

  getName(value:string){
    this.name=value;
  }
  getSize(size:NgForm){
    this.size=parseInt(size.value.size);
  }
  getPrice(price:NgForm){
    this.price=parseInt(price.value.price);
  }
  getImage(value:string){
    this.image=value;
  }
  
  OnClick(): void {
    console.log(this.name);
    console.log(this.size);
    console.log(this.price);
    console.log(this.image);
    //this.service.doPut(this.name, this.size, this.price, this.image);
  } 

}
