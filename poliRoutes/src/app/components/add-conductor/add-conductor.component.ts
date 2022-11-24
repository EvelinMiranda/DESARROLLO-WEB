import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Conductor } from 'src/app/Modelo/Conductor';
import{ServiceService } from '../../Service/service.service'


@Component({
  selector: 'app-add-conductor',
  templateUrl: './add-conductor.component.html',
  styleUrls: ['./add-conductor.component.css']
})
export class AddConductorComponent implements OnInit {
  driver = new Conductor;
  conductores:Conductor[]=[];
  constructor(private service:ServiceService, private router:Router)  { }

  ngOnInit(): void {
    this.service.getdrivers().subscribe(data=>{
      this.conductores=data;
      console.log(data);
    })
  }
  guardar(){
    const data ={
      name: this.driver.name,
      id: this.driver.id,
      dateIn: this.driver.dateIn
    };
    this.service.addDriver(data)
    .subscribe(data=>{
      alert("Registro de conductor exitoso!!");
      console.log(data);

    })

  }
  eliminar(conductor: Conductor){
    if(confirm("Está seguro de eliminar a este conductor?")){
      this.service.delete(conductor)
    .subscribe(data=>{
      this.conductores=this.conductores.filter(c=>c!==conductor);

    })
 
     }
    
  }

}
