import { Component } from '@angular/core';
import { Boots } from '../interfaces/boots';
import { Task1Service } from '../services/task1.service';
import { EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit{

  @Input() boots?:Boots
  @Output() updated:EventEmitter<null> = new EventEmitter();
  constructor(private service:Task1Service) {}

  ngOnInit(): void {
    
  }

  updateItems(){
    if(this.boots){
      this.service.putItems(this.boots).subscribe(
        ()=>{this.updated.emit();}
      );
    }
    this.refreshPage();
  }

  refreshPage(): void{
    window.location.reload();
  }

}
