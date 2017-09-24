import { Component, OnInit } from '@angular/core';
import { ViewAuthorsService } from '../../../../theme/services/authorsService/viewauthors.service';
import { LabelsService } from '../../../../theme/services/labelsService/labels.service';
import { IMyDpOptions } from 'mydatepicker';
import { TypeProjectsService } from '../../../../theme/services/typeProjectsService/typeprojects.service';
import { Authors } from '../../../../theme/services/authorsService/authors';
import { TypeProjects } from '../../../../theme/services/typeProjectsService/typeprojects';
import { Labels } from '../../../../theme/services/labelsService/labels';
import { Validators } from '@angular/forms';
import { Observable } from 'rxjs/Rx';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ViewProjectsService } from '../../../../theme/services/viewProjectsService/viewprojects.service';
import { Projects } from '../../../../theme/services/viewProjectsService/projects';
import { ViewSubProjectsService } from '../../../../theme/services/viewSubProjectsService/viewsubprojects.service';
import { SubProject } from '../../../../theme/services/viewSubProjectsService/subproject';

@Component({
  selector: 'editproject',
  styleUrls: ['./editproject.scss'],
  templateUrl: './editproject.html'
})

export class Editproject {

  public myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };

  subProject: SubProject = new SubProject();
  project: Projects = new Projects();
  typeProjects: TypeProjects[];
  projects: Projects[];
  subProjects : SubProject[];
  authors: Authors[];
  labels: Labels[];
  typeProject: TypeProjects = new TypeProjects();
  msgError: string;
  author: Authors = new Authors();
  label: Labels = new Labels();
  idgnrprj: number;
  idnprj: number;


  constructor(private _viewAuthorsService: ViewAuthorsService,
    private _labelsService: LabelsService,
    private _typeProjectsService: TypeProjectsService,
    private _viewProjectsService: ViewProjectsService,
    private route: ActivatedRoute,
    private router: Router,
    private _viewSubProjectsService: ViewSubProjectsService) {
    this.loadTypeProjects();
    this.loadAuthors();
    this.loadLabels();
  }

 
  ngOnInit(): void {
    this.route.params
    .switchMap((params: Params) => (this.idgnrprj = +params['id'],
  this._viewProjectsService.getProject(this.idgnrprj)))
  .subscribe(project => this.project = project);
 
  this.route.params
  .switchMap((params: Params) => (this.idnprj = +params['id'],
  this._viewSubProjectsService.getSubProject(this.idnprj)))
  .subscribe(subProject => this.subProject = subProject)

 
 
    }


    goSubProject() {
    let linkSub = ['pages/projects/subproject'];
    this.router.navigate(linkSub);
  }

  goDocument() {
    let link = ['pages/documents/newdocument'];
    this.router.navigate(link);

  }
  
  deleteProject(){
   if(confirm("¿Desea borrar el proyecto?")==true){
    this._viewProjectsService.deleteProject(this.project.idgnrprj)
    .subscribe(
    rt => console.log(rt),
    er => console.log(er),
    () => console.log('Terminado')
    );
   }
    
  }

  saveProject() {
    if(confirm("¿Desea guargar el proyecto?")==true){
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

  resetFormProject() {
    if(confirm("¿Desea cancelar la acción?")==true){
      this.project.idgnrprj = null;
      this.project.name = '';
      this.project.shortnamegnp = '';
      this.project.description = '';
      this.project.creationdate = '';
      this.typeProject.idnprjtype = null;
      this.typeProject.name = '';
      this.author.idnauthor = null;
      this.author.name = '';
      
    }
 
  }

  resetFormSubProject() {
    if(confirm("¿Desea cancelar la acción")==true){
      this.subProject.shortnamegnp = null;
      this.subProject.idnprj = null;
      this.subProject.name = '';
      this.subProject.shortnamespr = '';
      this.subProject.description = '';
      this.subProject.creationdate = '';
      this.author.idnauthor = null;
      this.author.name = '';
      this.label.idprjlabel = null;
      this.label.name = '';
    }
 
  }

  saveSubProject() {
    if(confirm("¿Desea Guardar un subproyecto?")==true){
      let conversionDate = this.subProject.creationdate.formatted;
      this.subProject.creationdate = conversionDate;
      this._viewSubProjectsService.addSubProject(this.subProject)
        .subscribe(
        rt => console.log(rt),
        er => console.log(er),
        () => console.log('Terminado')
        );
    }

  }

  updateProject() {
    //  if (!this.project) return;
    if(confirm("¿Desea Actualizar un proyecto?")==true){

      let conversionDate = this.project.creationdate.formatted;
      this.project.creationdate = conversionDate;
      this._viewProjectsService.putProject(this.project)
        .subscribe(
        rt => console.log(rt),
        er => console.log(er),
        () => console.log('Terminado')
        );
    }

  }

  updateSubProject() {
    //  if (!this.project) return;
    if(confirm("¿Desea Actualizar un Subproyecto?")==true){
      let conversionDate = this.subProject.creationdate.formatted;
      this.subProject.creationdate = conversionDate;
      this._viewSubProjectsService.putSubProject(this.subProject)
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

  loadLabels() {
    this._labelsService.getLabels()
      .subscribe(labels => this.labels = labels, error => this.msgError = <any>error);
  }

}