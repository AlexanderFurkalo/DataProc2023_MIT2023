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

  url:string="http://localhost:2831/api/boots"

  constructor(private http:HttpClient) { }

  getItems():Observable<Boots[]>{
    return this.http.get<Boots[]>(this.url + "/get");
  }

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
