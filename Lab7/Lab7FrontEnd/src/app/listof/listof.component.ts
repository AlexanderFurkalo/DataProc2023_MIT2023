import { Component, OnInit } from '@angular/core';
import { Boots } from '../interfaces/boots';
import { Task1Service } from '../services/task1.service';

@Component({
  selector: 'app-listof',
  templateUrl: './listof.component.html',
  styleUrls: ['./listof.component.scss']
})
export class ListofComponent implements OnInit{

  title:string="List of products";
  itemList:Boots[]=[];
  showAddForm:boolean=false;
  selectedItem?:Boots;

  constructor(private service:Task1Service) {}

  ngOnInit(): void{
    this.updateItems();
    this.service.list.subscribe(
      (list:Boots[])=>{this.itemList=list}
    );
  }

  updateItems(){
    this.service.getItems().subscribe(
      (items)=>{
        this.itemList = items._embedded.boots;
      }
    );
  }

  addItems(item:Boots){
    this.service.postItems(item).subscribe(
      (items)=>{
        this.updateItems();
      }
    );
    this.refreshPage();
  }

  onSelect(item:Boots){
    if(this.selectedItem && item.id==this.selectedItem.id){
      this.selectedItem=undefined;
    } else{
      this.selectedItem=item;
    }
  }

  deleteItems(item:Boots){
    this.service.deleteItems(item).subscribe(
      ()=>{
        this.updateItems();
      }
    );
    this.refreshPage();
  }

  refreshPage(): void{
    window.location.reload();
  }

}
