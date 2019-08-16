import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '../../node_modules/@angular/common/http';
import { Restaurants } from './restaurants';
import { tap, catchError } from 'rxjs/operators';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { FoodItems } from './food-items';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private currentUserSubject: BehaviorSubject<Customer>;
  public currentUser: Observable<Customer>;


  private headers = new HttpHeaders({ 'Content-Type': 'application/json' })
 
  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<Customer>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  getRestaurants(): Observable<Restaurants[]> {
    return this.http.get<Restaurants[]>('http://localhost:8082/PizzaOrderingSystem/customer/getrestaurants')
      .pipe(tap(_ => console.error('Error')),
        catchError(this.handleError<Restaurants[]>('Error')));
  }

  getFoodItems(): Observable<FoodItems[]> {
    return this.http.get<FoodItems[]>('http://localhost:8082/PizzaOrderingSystem/customer/getfooditems')
      .pipe(tap(_ => console.error('Error')),
        catchError(this.handleError<FoodItems[]>('Error')));
  }


  logincustomer(cid: string, password: string): Observable<Customer> {
    console.log('service called');
    const url1 = 'http://localhost:8082/PizzaOrderingSystem/customer/logincustomer';
    const lurl = `${url1}/${cid}/${password}`;
    return this.http.get<Customer>(lurl)
      .pipe(tap(customer => {
        localStorage.setItem('currentUser', JSON.stringify(customer));
        this.currentUserSubject.next(customer);
        return customer;
      }),
        catchError(this.handleError<Customer>(`Error`))
      );

  }
  signupcustomer(customer: Customer):Observable<any>{
    console.log('service called');  
    const url1= 'http://localhost:8082/PizzaOrderingSystem/customer/signupcustomer';
  
  return this.http.post(url1, customer).pipe(
    tap(_ => console.log(`fdsfd`)),
    catchError(this.handleError<Customer>(`error`))
  );

}


// signupcustomer(customer: Customer): Observable<Customer[]> {
//    console.log('signup called');
//    const url = 'http://localhost:8082/PizzaOrderingSystem/customer/signupcustomer';
//    return this.http.post<Customer[]>(url)
//    .pipe(tap(_ => console.error('Error')),
//    catchError(this.handleError<Customer[]>('Error'))
//    );
// }


  public get currentUserValue(): Customer {
    return this.currentUserSubject.value;
  }

  getCustomerbyid(cid: String): Observable<any> {
    console.log('service called');
    const url3 = 'http://localhost:8082/PizzaOrderingSystem/customer/getcustomerbyid';
    const lurl = `${url3}/${cid}`;
    return this.http.get<Customer>(lurl)
      .pipe(tap(_ => console.log(`logged in as=${cid}`)),
        catchError(this.handleError<Customer>(`Error`))
      );
  }






  private handleError<T>(operation = 'operation', result?: T) {

    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }




}
