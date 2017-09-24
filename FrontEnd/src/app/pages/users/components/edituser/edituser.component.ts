import { Component, OnInit } from '@angular/core';
import { RoleService } from '../../../../theme/services/roleService/role.service';
import { Role } from '../../../../theme/services/roleService/role';
import { Observable } from 'rxjs/Rx';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ViewUsersService } from '../../../../theme/services/viewUsersService/viewusers.service';
import { Users } from '../../../../theme/services/viewUsersService/users';
import { ViewUsers } from '../viewusers/viewusers.component';

@Component({
  selector: 'edituser',
  templateUrl: './edituser.html',
  styleUrls: ['./edituser.scss'],
  
})

export class Edituser implements OnInit {

  roles: Role[];
  user: Users = new Users();
  msgError: string;
  users = [];
  rol: Role = new Role();
  idnuser: number;


  constructor(
    private _roleService: RoleService,
    private _viewUsersService: ViewUsersService,
    private route: ActivatedRoute,
    private router: Router) {
    this.loadRoles();

  }

  ngOnInit(): void {
  this.route.params
  .switchMap((params: Params) => (this.idnuser = +params['idnuser'],
this._viewUsersService.getUser(this.idnuser)))
.subscribe(user => this.user = user);
  }

  resetForm() {

    if(confirm("¿Desea cancelar la accion?")){

      this.user.idnuser = null;
      this.user.name = '';
      this.user.lastname = '';
      this.user.nameuser = '';
      this.user.email = '';
      this.rol.idnrole = null;
      this.rol.namerole = '';

    }
   
    
  }


  updateUser() {
    
    if(confirm("¿Desea guardar el usuario editado?")){

      this._viewUsersService.putUser(this.user)
      .subscribe(
      rt => console.log(rt),
      er => console.log(er),
      );

    }

  }

  loadRoles() {

    this._roleService.getRole().subscribe(roles => this.roles = roles, error => this.msgError = <any>error);
  }  
}
