import { NgModule } from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';
import { NgbDropdownModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { routing } from './documents.routing';
import { Documents } from './documents.component';
import { Newdocument } from './components/newdocument/newdocument.component';
import { ModalsDocuments } from '../../theme/components/modals/documents/modalsdocuments.component';
import { Viewdocuments } from './components/viewdocuments/viewdocuments.component';
import { Editdocument } from './components/editdocument/editdocument.component';
import { DefaultModalsDocuments } from '../../theme/components/modals/documents/defaultmodalsdocuments/defaultmodalsdocuments.component';
import { ViewDocumentsService} from '../../theme/services/viewDocumentsService/viewdocuments.service';
import { HttpModule } from '@angular/http';
import { MyDatePickerModule } from 'mydatepicker';

import { Ng2SmartTableModule } from 'ng2-smart-table';
import { DataTableModule } from 'angular2-datatable';
import { DataFilterPipe } from './data-filter.pipe';
import { HotTable, HotTableModule } from 'ng2-handsontable';





@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    NgaModule,
    NgbModalModule,
    NgbDropdownModule,
    routing,
    HttpModule,
    MyDatePickerModule,
    Ng2SmartTableModule,
    DataTableModule,
    
    
  ],
  declarations: [
    Documents,
    Newdocument,
    Viewdocuments,
    Editdocument,
    ModalsDocuments,
    DefaultModalsDocuments,
    DataFilterPipe, 
   
  ],
   entryComponents: [
   DefaultModalsDocuments,
 
  ],
  providers: [
    ViewDocumentsService,

  ]
})
export class DocumentsModule {
}

