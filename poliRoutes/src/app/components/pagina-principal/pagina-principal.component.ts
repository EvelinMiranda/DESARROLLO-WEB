import { Component, OnInit } from '@angular/core';
import { Ruta } from 'src/app/Modelo/Ruta';
import { Conductor } from 'src/app/Modelo/Conductor';
import { Router } from '@angular/router';
import{ServiceService } from '../../Service/service.service'
import { ServiceRouteService } from '../../Service/service-route.service'
 


@Component({
  selector: 'app-pagina-principal',
  templateUrl: './pagina-principal.component.html',
  styleUrls: ['./pagina-principal.component.css'],

  
})
export class PaginaPrincipalComponent implements OnInit {
 
  driver = new Conductor;
  driver2 = new Conductor;


  conductoresArray: Conductor[]=[];
  
  

  rutasArray: Ruta[]=[]

  nuevaRuta: Ruta = new Ruta();
  opcionSeleccionado: string  = '0'; // Iniciamos
  verSeleccion: string        = '';




  tomarNombre(){
    
   //let n=localStorage.getItem("as")
    
   this.verSeleccion = this.opcionSeleccionado;
 

  }
  guardar(){
    console.log(this.verSeleccion);
    const data ={
      number: this.nuevaRuta.number,
      dateOut: this.nuevaRuta.dateOut,
      hourOut: this.nuevaRuta.hourOut,
      chairNumber: this.nuevaRuta.chairNumber,
      driver: this.conductoresArray.find(t=>t.name ===this.verSeleccion)
      
      
    };
    this.servceR.addRoutes(data)
    .subscribe(data=>{
      alert("Registro de ruta exitoso!!");
      console.log(data)
    })
    //let d = this.conductoresArray.filter(Conductor => this.conductoresArray.= "Juan");

    //let cond =  this.conductoresArray.find(t=>t.name ===this.verSeleccion);

    //this.service.getDriverForName(this.verSeleccion ).subscribe(data=>{
      //console.log(driver)
    //})
  }



  enviarMSM(ruta: Ruta){
    if(confirm("Está seguro de querer cancelar esta ruta?")){
     //ruta.fechaSalida="CANCELADO";
    // ruta.horaSalida="-----------";
    // ruta.silla=0;

    }


   
  }

  



  


  


  

  constructor(private service:ServiceService, private servceR:ServiceRouteService,private router:Router) {	 }

 
 
  ngOnInit(): void {
    this.service.getdrivers().subscribe(data=>{
      this.conductoresArray=data;
      console.log(data);
    })
    this.servceR.getRoutes().subscribe(data=>{
      this.rutasArray=data;
      console.log(data)
    })
  }
  


}
