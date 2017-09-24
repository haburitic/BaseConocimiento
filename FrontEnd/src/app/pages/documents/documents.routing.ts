  import { Routes, RouterModule } from '@angular/router';

import { Documents } from './documents.component';
import { Newdocument } from './components/newdocument/newdocument.component';
import { Viewdocuments } from './components/viewdocuments/viewdocuments.component';
import { Editdocument } from './components/editdocument/editdocument.component';


// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: '',
    component: Documents,
    children: [
      { path: 'newdocument', component: Newdocument },
      { path: 'viewdocuments', component: Viewdocuments },
      { path: 'editdocument/:idndocument', component: Editdocument },

    ]
  }
];

export const routing = RouterModule.forChild(routes);
