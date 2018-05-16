
start locator --name=locator --port=41111


start server --server-port=0  --locators=localhost[41111]  --name=server1
start server --server-port=0  --locators=localhost[41111]  --name=server2
start server --server-port=0  --locators=localhost[41111]  --name=server3
