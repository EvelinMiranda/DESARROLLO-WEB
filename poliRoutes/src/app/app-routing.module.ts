import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddConductorComponent } from './components/add-conductor/add-conductor.component';
import { LoginComponent } from './components/login/login.component';
import { PaginaPrincipalComponent } from './components/pagina-principal/pagina-principal.component';

const routes: Routes = [
  {path:'' , redirectTo:'principal', pathMatch:'full'},
  {path:'login', component:LoginComponent},
  {path:'principal', component:PaginaPrincipalComponent}
  ,{path:'addConductor', component: AddConductorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
