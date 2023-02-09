import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Boots } from '../interfaces/boots';

@Injectable({
  providedIn: 'root'
})
export class Task1Service {

  url:string="http://localhost:8081/Lab2BackEnd/servlet"

  constructor(private http:HttpClient) { }

  getItems():Observable<Boots[]>{
    return this.http.get<Boots[]>(this.url);
  }

  public doPut(name: Object, size: Object, price: Object, image: Object) {
    this.http.put(this.url + "?name="+name+"&size="+size+"&price="+price+"&image=assets/"+image+".JPG", image).subscribe(data => { console.log(data) });
  }
}
