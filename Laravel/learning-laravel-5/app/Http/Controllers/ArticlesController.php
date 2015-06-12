<?php namespace App\Http\Controllers;

use App\Article;
use App\Http\Requests;
use Illuminate\Http\Request;
use App\Http\Requests\ArticleRequest;

class ArticlesController extends Controller
{
    
    public function __construct(){
        $this->middleware("auth", ["except" => "index"]);
    }
    
    public function index(){
        $articles =  Article::latest('published_at')->published()->get();
        return view('articles.index', compact('articles'));
    }

    public function show($id){
        //dd('show');
        $article = Article::findOrFail($id);
        /*
        if(is_null($article)){
            abort(404);
        }
        */
        return view('articles.show', compact('article'));
    }

    public function create(){
        return view('articles.create');
    }

    public function store(ArticleRequest $request){
        //$input['published_at'] = Carbon::now();
        $article = Article::create($request->all());
        Auth::user()->article()->save($article);
        return redirect('articles');
    }

    public function edit($id){
        $article = Article::findOrFail($id);
        return view('articles.edit', compact('article'));
    }

    public function update(ArticleRequest $request, $id){
        $article = Article::findOrFail($id);
        $article->update($request->all());
        return redirect('articles');
    }

}
