import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Boots } from '../interfaces/boots';
import { Http } from '../interfaces/RestInterfaces/http';

import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Task1Service {

  list = new BehaviorSubject<Boots[]>([])

  url:string="http://localhost:2830/boots"

  constructor(private http:HttpClient) { }

  getItems():Observable<Http>{
    return this.http.get<Http>(this.url);
  }

  putItems(item:Boots):Observable<Boots[]>{
    return this.http.put<Boots[]>(this.url+`/${item.id}`,item);
  }

  postItems(item:Boots):Observable<Boots[]>{
    return this.http.post<Boots[]>(this.url, item);
  }

  deleteItems(item:Boots):Observable<Boots[]>{
    return this.http.delete<Boots[]>(this.url+`/${item.id}`);
  }


  setList(list:Boots[]){
    this.list.next(list);
  }
}
