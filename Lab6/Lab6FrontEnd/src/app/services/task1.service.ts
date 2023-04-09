import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Boots } from '../interfaces/boots';

import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Task1Service {

  list = new BehaviorSubject<Boots[]>([])

  url:string="http://localhost:2829/Lab6BackEnd/api/boots"

  constructor(private http:HttpClient) { }

  getItems():Observable<Boots[]>{
    return this.http.get<Boots[]>(this.url + "/get");
  }

  //public doPut(id: Object, name: Object, size: Object, price: Object, image: Object) {
  //  this.http.put(this.url + "?id="+id+ "?name="+name+"&size="+size+"&price="+price+"&image=assets/"+image+".JPG", image).subscribe(data => { console.log(data) });
  //}
  putItems(item:Boots):Observable<Boots[]>{
    return this.http.put<Boots[]>(this.url+"/update"+`/${item.id}`,item);
  }

  postItems(item:Boots):Observable<Boots[]>{
    return this.http.post<Boots[]>(this.url + "/add",item);
  }

  deleteItems(item:Boots):Observable<Boots[]>{
    return this.http.delete<Boots[]>(this.url+"/delete"+`/${item.id}`);
  }


  setList(list:Boots[]){
    this.list.next(list);
  }
}
