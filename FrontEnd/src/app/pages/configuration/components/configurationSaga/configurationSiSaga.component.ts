import { Component, OnInit } from '@angular/core';
import {ViewAuthorsService} from '../../../../theme/services/authorsService/viewauthors.service';
import {TypeProjectsService} from '../../../../theme/services/typeProjectsService/typeprojects.service';
import {LabelsService} from '../../../../theme/services/labelsService/labels.service';
import {RoleService} from '../../../../theme/services/roleService/role.service';
import {PermissionService} from '../../../../theme/services/permissionService/permission.service';
import {Role} from '../../../../theme/services/roleService/role';
import { Observable } from 'rxjs/Rx';
import { Authors } from '../../../../theme/services/authorsService/authors';
import { TypeProjects } from '../../../../theme/services/typeProjectsService/typeprojects';
import { Labels } from '../../../../theme/services/labelsService/labels';
import { Permission} from '../../../../theme/services/permissionService/permission';


@Component({
  selector: 'configurationsisaga',
  templateUrl: './configurationSiSaga.html',
  styleUrls: ['./configurationSiSaga.scss']
})
export class ConfigurationSaga {

  roles: Role[];
  authors: Authors[];
  typeProjects: TypeProjects[];
  labels: Labels[];
  msgError: string;
  permission: Permission = new Permission ();
  
permissions: Permission[];
 

  constructor(private _viewAuthorsService : ViewAuthorsService, 
    private _typeProjectsService : TypeProjectsService, 
    private _labelsService : LabelsService, 
    private _roleService : RoleService, 
    private _permissionService : PermissionService ) {
   
  this.loadRoles();  
  this.loadAuthors(); 
  this.loadTypeProjects();   
  this.loadLabels();  
  this.loadPermissions();
  
    
    }

    loadRoles(){


this._roleService.getRole()
.subscribe(roles => this.roles = roles, error => this.msgError = <any>error);
    }

    loadPermissions(){
      
      
      this._permissionService.getPermission()
      .subscribe(permissions => this.permissions = permissions, error => this.msgError = <any>error);
          }

    loadAuthors(){

      this._viewAuthorsService
      .getAuthors().subscribe(authors => this.authors = authors, error => this.msgError = <any>error);
    }

    loadTypeProjects(){
      
            this._typeProjectsService
            .getTypeProjects().subscribe(typeProjects => this.typeProjects = typeProjects, 
              error => this.msgError = <any>error);
          }

          loadLabels(){
            
            
            this._labelsService.getLabels()
            .subscribe(labels => this.labels = labels, error => this.msgError = <any>error);
                }
    
}
