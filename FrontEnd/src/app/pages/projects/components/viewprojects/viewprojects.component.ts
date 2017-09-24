import { Component } from '@angular/core';
import { ViewProjectsService } from '../../../../theme/services/viewProjectsService/viewprojects.service';
import { ViewSubProjectsService } from '../../../../theme/services/viewSubProjectsService/viewsubprojects.service';
import { ViewAuthorsService } from '../../../../theme/services/authorsService/viewauthors.service';
import { LabelsService } from '../../../../theme/services/labelsService/labels.service';
import { TypeProjectsService } from '../../../../theme/services/typeProjectsService/typeprojects.service';
import { IMyDpOptions } from 'mydatepicker';
import { Authors } from '../../../../theme/services/authorsService/authors';
import { TypeProjects } from '../../../../theme/services/typeProjectsService/typeprojects';
import { Labels } from '../../../../theme/services/labelsService/labels';
import { Projects } from '../../../../theme/services/viewProjectsService/projects';
import { SubProject } from '../../../../theme/services/viewSubProjectsService/subproject';
import { Location } from '@angular/common';
import { Validators } from '@angular/forms';
import 'rxjs/add/operator/switchMap';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { Editproject} from '../editproject/editproject.component';


@Component({
  selector: 'viewprojects',
  templateUrl: './viewprojects.html',
  styleUrls: ['./viewprojects.scss']
})
export class Viewprojects  {

  private myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };

  typeProjects: TypeProjects[];
  projects: Projects[];
  subProject: SubProject[];
  authors: Authors[];
  labels: Labels[];
  msgError: string;
  filterQuery = "" ;
  rowsOnPage = 10;
  sortBy = 'shortnamegnr';
  sortOrder = 'asc';
  projectSelection: Projects;
  subProjectSelection: SubProject;

  constructor(private _viewProjectsService: ViewProjectsService,
    private _viewSubProjectsService: ViewSubProjectsService,
    private _viewAuthorsService: ViewAuthorsService,
    private _labelsService: LabelsService, private _typeProjectsService: TypeProjectsService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location
  ) {

    this.loadTypeProjects();
    this.loadAuthors();
    this.loadLabels();
    this.loadProjects();
    this.loadSubProjects();
   
  }

  ngOnitInit() {
    

  }

  toInt(num: string) {
    return +num;
}

sortByWordLength = (a: any) => {
    return a.shortnamegnr.length;
}


goEditProject(project: Projects){
  if(confirm("¿Desea Actualizar un proyecto?")==true){
    this.projectSelection = project;
    let id = this.projectSelection.idgnrprj;
      let link = ['pages/projects/editproject', id ];
      this.router.navigate(link);  
  }
  
  }


  goDeleteProject(project: Projects){
    if(confirm("¿Desea Eliminar un Proyecto?")==true){
      this._viewProjectsService.deleteProject(project.idgnrprj)
      .subscribe(
        rt => console.log(rt),
        er => console.log(er),
        () => console.log('Terminado')
      
        );

    }

  }

  goDeleteSubProject(subProject: SubProject){
    if(confirm("¿Desea Eliminar un Subproyecto?")==true){
      this._viewSubProjectsService.deleteSubProject(subProject.idnprj)
      .subscribe(
        rt => console.log(rt),
        er => console.log(er),
        () => console.log('Terminado')
      
        );
      
    }

      }
  
  goEditSubProject(subProject: SubProject){
    if(confirm("¿Desea Editar el subproyecto?")==true){
     this.subProjectSelection = subProject;
     let id = this.subProjectSelection.idnprj;
     let link = ['pages/projects/editproject',id ];
     this.router.navigate(link);  

    }
    
    }
  

  loadSubProjects() {

    this._viewSubProjectsService
      .getSubProjects().subscribe(subProject => this.subProject = subProject, error => this.msgError = <any>error);
  }

  loadProjects() {

    this._viewProjectsService
      .getProjects().subscribe(projects => this.projects = projects, error => this.msgError = <any>error);
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

    this._labelsService.getLabels().
      subscribe(labels => this.labels = labels, error => this.msgError = <any>error);
  }

}

