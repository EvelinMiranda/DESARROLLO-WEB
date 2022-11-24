 import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Ruta } from '../Modelo/Ruta';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceRouteService {

  constructor(private http:HttpClient) { }
  Url='http://localhost:8080/api/v1/routes'


  getRoutes(){
    return this.http.get<Ruta[]>(this.Url);
  }

  addRoutes(data: any): Observable<any> {
    return this.http.post(this.Url, data);
  }


}
