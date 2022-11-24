import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Conductor } from '../Modelo/Conductor';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {


  

  constructor(private http:HttpClient) { }
  Url='http://localhost:8080/api/v1/drivers'

  getdrivers(){
    return this.http.get<Conductor[]>(this.Url);
  }

 
  addDriver(data: any): Observable<any> {
    return this.http.post(this.Url, data);
  }

  delete(conductor: Conductor) {
    return this.http.delete(this.Url+"/"+conductor.id);
  }

  getDriverForName(name:String){
    return this.http.get<Conductor>(this.Url+"/"+name)

  }



}
