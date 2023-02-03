import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Boots } from '../interfaces/boots';

@Injectable({
  providedIn: 'root'
})
export class Task1Service {

  url:string="http://localhost:8080/Lab1/servlet"

  constructor(private http:HttpClient) { }

  getItems():Observable<Boots[]>{
    return this.http.get<Boots[]>(this.url);
  }
}
