import { Routes, RouterModule } from '@angular/router';

import { Configuration } from './configuration.component';
import { ConfigurationSaga} from './components/configurationSaga/configurationSiSaga.component';


// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: '',
    component: Configuration,
    children: [
      { path: 'configurationsisaga', component: ConfigurationSaga },
     

    ]
  }
];

export const routing = RouterModule.forChild(routes);
