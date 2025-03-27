import requests
import os
from langchain_openai import ChatOpenAI
from langchain.agents import initialize_agent, Tool
from dotenv import load_dotenv

load_dotenv()

api_key = os.getenv('OPENAI_API_KEY')

def get_parsed_class():
    res = requests.get("http://localhost:3000/api/parsed-class")
    return res.json()

tools = [
    Tool(
        name="GetJavaClassStructure",
        func=lambda x: get_parsed_class(),
        description="Use this to get the structure of a Java class (name and methods)."
    )
]

llm = ChatOpenAI(temperature=0)
agent = initialize_agent(tools, llm, agent="zero-shot-react-description", verbose=True)

response = agent.run("What does this Java class contain?")
print(response)
