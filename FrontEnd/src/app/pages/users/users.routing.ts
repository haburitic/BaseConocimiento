import { Routes, RouterModule }  from '@angular/router';
import { Users } from './users.component';
import { Edituser } from './components/edituser/edituser.component';
import { Newuser } from './components/newuser/newuser.component';
import { ViewUsers } from './components/viewusers/viewusers.component';

// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: '',
    component: Users,
    children: [
      { path: 'edituser/:idnuser', component: Edituser },
      { path: 'newuser', component: Newuser },
      { path: 'viewusers', component: ViewUsers},
    
    ]
  }
];

export const routing = RouterModule.forChild(routes);
