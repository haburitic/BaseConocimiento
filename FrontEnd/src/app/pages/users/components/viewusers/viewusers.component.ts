import { Component } from '@angular/core';
import { ViewUsersService } from '../../../../theme/services/viewUsersService/viewusers.service';
import { RoleService } from '../../../../theme/services/roleService/role.service';
import { Role } from '../../../../theme/services/roleService/role';
import { Observable } from 'rxjs/Rx';
import { Users } from '../../../../theme/services/viewUsersService/users';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Validators } from '@angular/forms';
import { Edituser } from '../edituser/edituser.component';

@Component({
  selector: 'viewusers',
  templateUrl: './viewusers.html',
  styleUrls: ['./viewusers.scss'],
  
 
})

export class ViewUsers {
  
  user: Users = new Users();
  roles: Role[];
  users: Users[];
  msgError: string;
  filterQuery = "" ;
  rowsOnPage = 10;
  sortBy = 'name';
  sortOrder = 'asc';
  userSelection: Users;

  constructor(private _viewUsersService: ViewUsersService, 
    private _roleService: RoleService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location) {

    this.loadRoles();
    this.loadUsers();
  }

  ngOnitInit() {
    

  }
    
  toInt(num: string) {
    return +num;
}

sortByWordLength = (a: any) => {
    return a.name.length;
}


goDeleteUser(user: Users){
  if(confirm("¿Desea borrar el usuario?") == true){

    this._viewUsersService.deleteUser(user.idnuser)
    .subscribe(
      rt => console.log(rt),
      er => console.log(er),
      () => console.log('Terminado')
    
      );

  }
 
  
    }

goEditUser(user: Users){

  if(  confirm("¿Desea Editar el usuario?") == true) {
    
    this.userSelection = user;
    let link = ['pages/users/edituser', this.userSelection.idnuser];
    this.router.navigate(link); 
    
        } 
  

}

  loadRoles() {

    this._roleService.getRole().subscribe(roles => this.roles = roles, error => this.msgError = <any>error);
  }

  loadUsers() {

    this._viewUsersService.getUsers().subscribe(users => this.users = users, error => this.msgError = <any>error);
  }

}
