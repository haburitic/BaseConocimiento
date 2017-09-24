import { Component } from '@angular/core';
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
  selector: 'newdocument',
  templateUrl: './newdocument.html',
  styleUrls: ['./newdocument.scss'],


})

export class Newdocument {




  document: Documents = new Documents();
  msgError: String;

  public fileUploaderOptions: NgUploaderOptions = {
    // url: 'C:/Users/jomacias/Music'
    url: 'C:/Users/jomacias/Music/',
  };

  public uploaderOptions:NgUploaderOptions = {
    // url: 'http://website.com/upload'
    url: 'C:/Users/jomacias/Music/',
  };
  public myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  }

  constructor(
    private _viewDocumentsService: ViewDocumentsService,
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnitInit() {
    let id = this.route.snapshot.params['id'];
    if (!id) return;
    console.log(id);
  }

  goLista() {
    let link = [];
    this.router.navigate(link);

  }

  resetForm() {

    if(confirm("¿Desea cancelar la acción?")){
      this.document.idndocument = null;
      this.document.shortnamedoc = '';
      this.document.name = '';
      this.document.description = '';
      this.document.creationdate = '';
      this.document.shortnamespr = null;
    }
  }

  saveDocument() {

    if(confirm("¿Desea agregar un documento?")==true){

      let conversionDate = this.document.creationdate.formatted;
      this.document.creationdate = conversionDate;
      let conversionfile = 'C:/Users/jomacias/Music/pom.xml';
      this.document.file = conversionfile;
      console.log(conversionfile);
      this._viewDocumentsService.addDocument(this.document)
        .subscribe(
        rt => console.log(rt),
        er => console.log(er),
        () => console.log('Terminado')
  
        );

    }
  
  }

  updateDocument() {
    //  if (!this.document) return;
   
  if(confirm("¿Desea actualizar un documento?")==true){
    this._viewDocumentsService.putDocument(this.document)
    .subscribe(
    rt => console.log(rt),
    er => console.log(er),
    () => this.goLista()
    );

  }

  }

}
