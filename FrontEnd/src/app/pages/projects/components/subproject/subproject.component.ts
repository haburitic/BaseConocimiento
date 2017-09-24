import { Component } from '@angular/core';
import { ViewAuthorsService } from '../../../../theme/services/authorsService/viewauthors.service';
import { LabelsService } from '../../../../theme/services/labelsService/labels.service';
import { IMyDpOptions } from 'mydatepicker';
import { Observable } from 'rxjs/Rx';
import { Authors } from '../../../../theme/services/authorsService/authors';
import { Labels } from '../../../../theme/services/labelsService/labels';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ViewSubProjectsService } from '../../../../theme/services/viewSubProjectsService/viewsubprojects.service';
import { SubProject } from '../../../../theme/services/viewSubProjectsService/subproject';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'subproject',
  templateUrl: './subproject.html',
  styleUrls: ['./subproject.scss']
})

export class Subproject {
  public myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };

  authors: Authors[];
  labels: Labels[];
  msgError: string;
  label: Labels = new Labels();
  author: Authors = new Authors();
  subProject: SubProject = new SubProject();

  constructor(private _viewAuthorsService: ViewAuthorsService,
    private _labelsService: LabelsService,
    private _viewSubProjectsService: ViewSubProjectsService,
    private route: ActivatedRoute,
    private router: Router,
  ) {

    this.loadAuthors();
    this.loadLabels();
  }

  ngOnitInit() {
    let id = this.route.snapshot.params['id'];
    if (!id) return;
    console.log(id);
  }

  goDocument() {
    if(confirm("¿Desea guardar el subproyecto y agregar un documento?")==true){

      this.saveSubProject();
      let link = ['pages/documents/newdocument'];
      this.router.navigate(link);
    }
  
  }

  resetForm() {
    if(confirm("¿Desea cancelar la acción?")==true){
      this.subProject.idnprj = null;
      this.subProject.shortnamegnp = '';
      this.subProject.name = '';
      this.subProject.shortnamespr = '';
      this.subProject.creationdate = '';
      this.subProject.description = '';
      this.label.idprjlabel = null;
      this.label.name = '';
      this.author.idnauthor = null;
      this.author.name = '';
    }
  
  }

  saveSubProject() {
   if(confirm("¿Desea guardar un subproyecto?")==true){
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

  loadAuthors() {
    this._viewAuthorsService.getAuthors()
    .subscribe(authors => this.authors = authors, error => this.msgError = <any>error);
  }

  loadLabels() {
    this._labelsService.getLabels()
    .subscribe(labels => this.labels = labels, error => this.msgError = <any>error);
  }

}
