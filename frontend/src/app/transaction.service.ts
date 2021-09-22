import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Transaction } from 'src/transaction';
import { Observable, throwError } from 'rxjs';
import { map, catchError, tap} from 'rxjs/operators';
import { Comment } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  url="http://localhost:8282/transaction";
  urlc = "http://localhost:8282"
  private headers = new HttpHeaders({'content-type':'application/json'});

  constructor(private http:HttpClient) {     }
  fetchClients(id:string):Observable<any>
  {
      return this.http.get(`${this.urlc}/bank/${id}`);
  }

  //public addtransaction(transaction: Transaction)
  //{
  //}
  public addtransaction(transaction:Transaction):
    //print();
    Observable <Transaction> {
  return this.http.post<Transaction>(this.url, JSON.stringify(transaction),{headers:this.headers})}

  }
  