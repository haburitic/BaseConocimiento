import { Component } from '@angular/core';
import { ViewAuthorsService } from '../../../../theme/services/authorsService/viewauthors.service';
import { TypeProjectsService } from '../../../../theme/services/typeProjectsService/typeprojects.service';
import { IMyDpOptions } from 'mydatepicker';
import { Observable } from 'rxjs/Rx';
import { Authors } from '../../../../theme/services/authorsService/authors';
import { TypeProjects } from '../../../../theme/services/typeProjectsService/typeprojects';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ViewProjectsService } from '../../../../theme/services/viewProjectsService/viewprojects.service';
import { Projects } from '../../../../theme/services/viewProjectsService/projects';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'generalproject',
  templateUrl: './generalproject.html',
})

export class Generalproject {

  public myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',    
  };

  project: Projects = new Projects();
  typeProjects: TypeProjects[];
  authors: Authors[];
  msgError: string;  
  creationdate2: string;
  author: Authors = new Authors();
  typeProject: TypeProjects = new TypeProjects();
  active = true;

  constructor(private _viewAuthorsService: ViewAuthorsService,
    private _typeProjectsService: TypeProjectsService,
    private _viewProjectsService: ViewProjectsService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location,
  ) {
    this.loadTypeProjects();
    this.loadAuthors();
  }

  ngOnitInit() {
    let id = this.route.snapshot.params['id'];
    if (!id) return;
    console.log(id);
  }

  resetForm() {
    if(confirm("¿Desea cancelar la acción?")==true){
      this.project.shortnamegnp = '';
      this.project.name = '';
      this.project.description = '';
      this.project.creationdate = '';
      this.typeProject.idnprjtype = null;
      this.typeProject.name = '';
      this.author.idnauthor = null;
      this.author.name = '';
    }

   }

  goSubProject() {
    if(confirm("¿Desea Guardar y agregar un SubProyecto?")==true){
      this.saveProject();
      let link = ['pages/projects/subproject'];
      this.router.navigate(link);     
    }
  }

  saveProject() {
    if(confirm("¿Desea Guardar un SubProjecto?")==true){
      let conversionDate = this.project.creationdate.formatted;
      this.project.creationdate = conversionDate;
      this._viewProjectsService.addProject(this.project)
      .subscribe(
      rt => console.log(rt),
      er => console.log(er),
      () => console.log('Terminado')
        );
    }

  }

  loadTypeProjects() {
    this._typeProjectsService.getTypeProjects()
    .subscribe(typeProjects => this.typeProjects = typeProjects, error => this.msgError = <any>error);
  }

  loadAuthors() {
    this._viewAuthorsService.getAuthors()
    .subscribe(authors => this.authors = authors, error => this.msgError = <any>error);
  }

}
