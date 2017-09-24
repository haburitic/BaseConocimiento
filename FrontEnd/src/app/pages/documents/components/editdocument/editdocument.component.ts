import { Component, OnInit } from '@angular/core';
import { IMyDpOptions } from 'mydatepicker';
import { Observable } from 'rxjs/Rx';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ViewDocumentsService } from '../../../../theme/services/viewDocumentsService/viewdocuments.service';
import { Documents } from '../../../../theme/services/viewDocumentsService/documents';
import { ViewSubProjectsService } from '../../../../theme/services/viewSubProjectsService/viewsubprojects.service';
import { SubProject } from '../../../../theme/services/viewSubProjectsService/subproject';
import { NgUploaderOptions } from 'ngx-uploader';

@Component({
  selector: 'editdocument',
  templateUrl: './editdocument.html',
  styleUrls: ['./editdocument.scss']
})
export class Editdocument {

  document: Documents = new Documents();
  documents = [];
  idndocument: number;
  msgError: String;

  public fileUploaderOptions: NgUploaderOptions = {
    // url: 'http://website.com/upload'
    url: 'C:\Users\jomacias\Documents\Chalo',
  };

  public myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  }

  constructor(private _viewDocumentsService: ViewDocumentsService,
    private route: ActivatedRoute,
    private router: Router) {

  }

  ngOnInit(): void {
    this.route.params
    .switchMap((params: Params) => (this.idndocument = +params['idndocument'],
  this._viewDocumentsService.getDocument(this.idndocument)))
  .subscribe(document => this.document = document);
    }


  goLista() {

    let link = [];
    this.router.navigate(link);

  }

  resetForm(){
    if(confirm("¿Desea cancelar la acción?")==true){
      this.document.idndocument = null ;
      this.document.shortnamedoc = '';
      this.document.name = '';
      this.document.description = '';
      this.document.creationdate = '';
      this.document.shortnamespr = null;

    }
 
  }
  

  updateDocument() {
    //  if (!this.document) return;
    if(confirm("¿Desea actualizar el documento?")==true){
      let conversionDate = this.document.creationdate.formatted;
      this.document.creationdate = conversionDate;
      this._viewDocumentsService.putDocument(this.document)
        .subscribe(
        rt => console.log(rt),
        er => console.log(er),
        () => console.log('Terminado')
        );

    }
 
  }

}
