import { Component } from '@angular/core';
import { ViewDocumentsService } from '../../../../theme/services/viewDocumentsService/viewdocuments.service';
import { IMyDpOptions } from 'mydatepicker';
import { Documents } from '../../../../theme/services/viewDocumentsService/documents';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/switchMap';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Editdocument } from '../editdocument/editdocument.component';
import { Location } from '@angular/common';
import { Validators } from '@angular/forms';

@Component({
  selector: 'viewdocuments',
  templateUrl: './viewdocuments.html',
  styleUrls: ['./viewdocuments.scss']
})

export class Viewdocuments {

  private myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };

  documents: Documents[];
  msgError: string;
  filterQuery = "" ;
  rowsOnPage = 10;
  sortBy = 'shortnamegnr';
  sortOrder = 'asc';
  documentSelection: Documents;

  constructor(private _viewDocumentsService: ViewDocumentsService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location) {

    this.loadDocuments();
  }

  ngOnitInit() {
    

  }
  
  toInt(num: string) {
    return +num;
}


goEditDocument(document: Documents){
  if(confirm("¿Desea editar un documento?")==true){
    this.documentSelection = document;
    let link = ['pages/documents/editdocument', this.documentSelection.idndocument];
    this.router.navigate(link);  
  }
  
  }

sortByWordLength = (a: any) => {
    return a.shortnamegnr.length;
}

goDeleteDocument(document: Documents){

  if(confirm("¿Desea borrar el documento?")== true){
  
    this._viewDocumentsService.deleteDocument(document.idndocument)
    .subscribe(
      rt => console.log(rt),
      er => console.log(er),
      () => console.log('Terminado')
    
      );
  }

    }

  loadDocuments() {

    this._viewDocumentsService.getDocuments()
    .subscribe(documents => this.documents = documents, error => this.msgError = <any>error);
  }
}
