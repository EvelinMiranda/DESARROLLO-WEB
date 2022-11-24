import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/Modelo/Usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  
  miImagen:String ="assets/imagen.jpg"

  constructor() { }

  ngOnInit(): void {
  }

}
